(ns scramblies.scramble-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [scramblies.scramble :refer [scramble]]))

(deftest scramble-test
  (testing "scramble"
    (is (= 1 1))))
