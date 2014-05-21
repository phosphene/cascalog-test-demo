(ns cascalog-test-demo.core-test
 (:use [cascalog-test-demo.core]
       [cascalog.api]
       [midje sweet cascalog])
)

(let [src [[1 2] [1 3]
           [3 4] [3 6]
           [5 2] [5 9]]]
  (facts "basic-query produces 2-tuples from src"
         (basic-query src) => (produces [[3 10] [1 5] [5 11]])  ;; true
         (basic-query src) => (produces [[1 5] [3 10] [5 11]]))) ;; true



