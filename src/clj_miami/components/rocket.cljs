(ns clj-miami.components.rocket
  (:require [reagent.core :as reagent]
            [clj-miami.state :refer [app-state]]
            [cljsjs.jquery-ui]))

(defn rocket-component-render
  []
  [:img.rocket.animated {:className (get-in @app-state [:lift-off :rocket]) :src "img/rocket.png"}])

(defn lift-off
  []
  (swap! app-state update-in [:countdown] - 1)
  (.setTimeout js/window #(lift-off) 1000)
  (if (zero? (:countdown @app-state))
    (swap! app-state assoc-in [:lift-off :rocket] "fadeOutUpBig")))

(defn rocket-component-did-mount
  [this]
  (js/$ (fn []
          (let [$this (js/$ (reagent/dom-node this))]
            (.droppable $this #js{:accept ".cat"
                                  :drop (fn [event, ui]
                                          (let [ $origin (js/$ (:draggable (js->clj ui :keywordize-keys true)))]
                                            (.hide $origin)
                                            (swap! app-state update-in [:catstronauts] - 1)
                                            (swap! app-state update-in [:on-board] + 1)
                                            (if (and (= (:catstronauts @app-state) 0) (= (:on-board @app-state) 4))
                                              (do
                                                (swap! app-state assoc-in [:lift-off :launch-pad] "shake")
                                                (lift-off)))))})))))

(defn rocket-component
  []
  (reagent/create-class {:reagent-render rocket-component-render
                         :component-did-mount rocket-component-did-mount}))

(defn shuttle-component
  []
  [:div.col-xs-6
   [:div.launch-pad.animated.infinite.text-center
    {:className (get-in @app-state [:lift-off :launch-pad])}
    [rocket-component]]])

