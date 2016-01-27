(ns clj-miami.components.greeting
  (:require [clj-miami.state :refer [app-state]]))

(defn greeting-component
  []
  [:div.col-xs-12
   [:div.greeting.text-center>h1 (:greeting @app-state)]])
