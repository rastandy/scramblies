(ns scramblies.handler.scramble-test
  (:require [clojure.test :refer :all]
            [integrant.core :as ig]
            [ring.mock.request :as mock]
            [scramblies.handler.scramble :as scramble]))

(deftest smoke-test
  (testing "scramble handler"
    (let [handler  (ig/init-key :scramblies.handler/scramble {})
          response (handler (mock/request :get "/scramble"))]
      (is (= 200 (:status response)) "response ok"))))
