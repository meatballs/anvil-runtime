(ns anvil.runtime.tables.v2.table-types-test
  (:require [clojure.test :refer :all]
            [anvil.runtime.tables.v2.table-types :as table-types]))

(deftest split-simple-object-false-is-stored-as-json
  (let [reduce-split (partial table-types/reduce-val-for-update {:split true} {:type "simpleObject"})]
    ;; A top-level false is a JSON value, not a missing one
    (is (= ["false"] (reduce-split false)))
    (is (= ["0"] (reduce-split 0)))
    (is (= [nil] (reduce-split nil)))))
