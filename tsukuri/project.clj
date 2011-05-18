(defproject gaeshi/tsukuri "0.5.1"
  :description "Development library for Gaeshi, a Clojure framework for Google App Engine apps."
  :license {:name "The MIT License"
            :url "file://LICENSE"
            :distribution :repo
            :comments "Copyright © 2011 Micah Martin All Rights Reserved."}
  :repositories {"releases" "http://appengine-magic-mvn.googlecode.com/svn/releases/"}
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [speclj "1.3.1"]
                 [mmargs "1.2.0"]
                 [fresh "1.0.2"]
                 [com.google.appengine/appengine-api-labs "1.5.0"]
                 [com.google.appengine/appengine-api-stubs "1.5.0"]
                 [com.google.appengine/appengine-local-runtime "1.5.0"]
                 [com.google.appengine/appengine-local-runtime-shared "1.5.0"]
                 [com.google.appengine/appengine-testing "1.5.0"]
                 [tomcat/jasper-runtime "5.0.28"]
                 [jstl "1.1.2"]
                 [taglibs/standard "1.1.2"]
                 [commons-el "1.0"]
                 [org.apache.geronimo.specs/geronimo-jsp_2.1_spec "1.0.1"]
                 [filecabinet "1.0.1"]]
  :dev-dependencies [[speclj "1.4.0"]
                     [lein-clojars "0.6.0"]
                     [com.google.appengine/appengine-api-1.0-sdk "1.5.0"]
                     [ring/ring-servlet "0.3.7"]]
  :test-path "spec/"
  :java-source-path "src/"
  :resources-path "resources/")
