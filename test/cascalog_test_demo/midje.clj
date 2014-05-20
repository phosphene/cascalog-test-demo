(ns cascalog_test_demo.midje
  (:use [midje.sweet]))

(fact (+ 2 2) => 5)
(fact (+ 2 2) => odd?)
