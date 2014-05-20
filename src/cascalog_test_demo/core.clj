(ns cascalog-test-demo.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)]
        [cascalog.checkpoint])
  (:require [cascalog.logic.ops :as c]
            [cascalog.logic.def :as def]
            [cascalog.logic.vars :as v]
            [clojure.string :as s]))

;;; This is an incorrect implementation, such as might be written by
;;; someone who was used to a Lisp in which an empty list is equal to
;;; nil.
(defn first-element [sequence default]
  (if (nil? sequence)
    default
    (first sequence)))
