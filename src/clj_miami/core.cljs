(ns clj-miami.core
  (:require [reagent.core :as reagent]
            [clj-miami.state :refer [app-state]]
            [clj-miami.component.greeting :as g]
            [clj-miami.component.houston :as h]
            [clj-miami.component.catstronaut :as c]
            [clj-miami.component.shuttle :as s]
            [cljsjs.jquery-ui]))

(enable-console-print!)

(defn main []
  [:div.container
   [:div.row
    [g/greeting-component]
    [h/houston-component]
    [c/catstronaut-component]
    [s/shuttle-component]
    ]])

(reagent/render-component [main]
                          (. js/document (getElementById "app")))
