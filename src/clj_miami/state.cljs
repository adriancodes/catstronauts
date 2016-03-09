(ns clj-miami.state
  (:require [reagent.core :as reagent :refer [atom]]))


(def app-state (atom {:greeting "CATS IN OUTER SPACE!"
                      :catstronauts 4
                      :on-board 0
                      :countdown 10
                      :lift-off {:launch-pad ""
                                 :rocket ""}}))
