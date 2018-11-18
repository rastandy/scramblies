(ns scramblies.handler.scramble
  (:require [compojure.core :refer :all]
            [integrant.core :as ig]
            [scramblies.scramble :refer [scramble]]))

(defmethod ig/init-key :scramblies.handler/scramble [_ options]
  (context "/scramble" []
           (GET "/" [str1 str2]
                {:body {:data (scramble str1 str2)}
                 :headers {"Access-Control-Allow-Origin" "*"}})))
