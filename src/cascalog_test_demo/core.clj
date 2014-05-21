(ns cascalog-test-demo.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)]
        [cascalog.checkpoint])
  (:require [cascalog.logic.ops :as c]
            [cascalog.logic.def :as def]
            [cascalog.logic.vars :as v]
            [clojure.string :as s]))


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

