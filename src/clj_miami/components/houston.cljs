(ns clj-miami.components.houston
  (:require [clj-miami.state :refer [app-state]]))

(defn countdown-component
  []
  (if (> 1 (:countdown @app-state))
    [:h2.animated.infinite.flash "LIFT-OFF!"]
    [:h2 "T-MINUS: " (:countdown @app-state)]))

(defn houston-component
  []
  [:div.houston
   [:div.col-xs-4
    [:h2 "Catstronauts: " (:catstronauts @app-state)]]
   [:div.col-xs-4>div.countdown {:className (if (= 10 (:countdown @app-state)) "hide")} [countdown-component]]
   [:div.col-xs-4 [:h2 (str "On Board: " (:on-board @app-state))]]])

