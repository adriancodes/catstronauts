(ns clj-miami.components.catstronaut
  (:require [reagent.core :as reagent]
            [clj-miami.state :refer [app-state]]
            [cljsjs.jquery-ui]))

(defn cat-component-render
  [cat-index]
  [:img.cat {:src (str "img/cat" cat-index ".png")}])

(defn cat-component-did-mount
  [this]
  (js/$ (fn []
          (let [$this (js/$ (reagent/dom-node this))]
            (.draggable $this #js{:revert "invalid"
                                  :helper "clone"
                                  :opacity .7
                                  :containment "document"
                                  :appendTo "body"
                                  :drag (fn [event, ui])})))))

(defn cat-component
  [cat-index]
  (reagent/create-class {:reagent-render cat-component-render
                         :component-did-mount cat-component-did-mount}))

(defn catstronaut-component
  []
  [:div.col-xs-6
   [:div.draggable.text-center
    [:div (:countdown @app-state)]
    [:ul (for [cat-index (range 1 5)]
           ^{:key cat-index}
           [:li [cat-component cat-index]])]]])
