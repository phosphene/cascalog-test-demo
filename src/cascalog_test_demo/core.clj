(ns cascalog-test-demo.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)]
        [cascalog.checkpoint])
  (:require [cascalog.logic.ops :as c]
            [cascalog.logic.def :as def]
            [cascalog.logic.vars :as v]
            [clojure.string :as s]))


;; In Cascalog as in Cascading the basic data structure is the tuple
;; Tuples are distinguished from sets for example
;; A tuple may contain multiple instances of the same element, so
;; tuple (1,2,2,3) \neq (1,2,3); but set \{1,2,2,3\} = \{1,2,3\}.
;; Tuple elements are ordered: tuple (1,2,3) \neq (3,2,1), but set \{1,2,3\} = \{3,2,1\}.
;; A tuple has 'n' number of elements
;; another way of reasoning about tuples is as an abstraction from "multiple"
;; n-mutiple is n-tuple 

;;demonstrate basic query syntax
;; query creation operator: <- 
;; what we want: [?x ?sum]
;; the input: (src ?x ?y)
;; an operation: sort on x :  (:sort ?x) 
;; the result, note ':>' : (c/sum ?y :> ?sum)))
;; modified from example

(defn basic-query [src]
  (<- [?x ?sum]
      (src ?x ?y)
      (:sort ?x)
      (c/sum ?y :> ?sum)))



(defn another-basic-query [src]
  (<- [?x ?sum]
      (src ?x ?y ?z)
      (+ ?y ?z :> ?inter)
      (:sort ?x)
      (c/sum ?inter :> ?sum)))






;;latest cascalog api
(def/defmapcatfn tokenise [line]
  "reads in a line of string and splits it by a regular expression"
  (s/split line #"[\[\]\\\(\),.)\s]+"))

;;demonstrate word count

(defn word-count-tokenise [src]
  "word count and split each line in tuples"
  (<- [?word ?count]
      (src ?line)
      (tokenise ?line :> ?word)
      (c/count ?count)))

