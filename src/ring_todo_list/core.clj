(ns ring-todo-list.core
  (:require
   [ring.adapter.jetty :as jetty]
   [ring.middleware.cors :refer [wrap-cors]]))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello Clojure, Hello Ring!"})

(def _handler
  (wrap-cors handler
             :access-control-allow-origin [#"http://localhost:8280"]
             :access-control-allow-methods [:get :put :post :delete]))

(defn -main []
  (jetty/run-jetty _handler {:port 3000}))