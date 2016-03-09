(ns clj-miami.core
  (:require [reagent.core :as reagent]
            [clj-miami.state :refer [app-state]]
            [clj-miami.components.greeting :as g]
            [clj-miami.components.houston :as h]
            [clj-miami.components.catstronaut :as c]
            [clj-miami.components.rocket :as r]
            [cljsjs.jquery-ui]))

(enable-console-print!)

(defn instruction-component
  []
  [:div.col-xs-12
   [:h4 "Drag and drop each brave catstronaut into the \"Rok 1T\.""]])

(defn main []
  [:div.container
   [:div.row
    [g/greeting-component]
    [h/houston-component]
    [c/catstronaut-component]
    [r/shuttle-component]
    [instruction-component]
   
    ]])

(reagent/render-component [main]
                          (. js/document (getElementById "app")))
