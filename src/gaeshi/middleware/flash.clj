(ns gaeshi.middleware.flash)

(defn- read-flash [request]
  (let [session (:session request)
        flash (:_flash session)
        session (dissoc session :_flash)]
    (if flash
      (assoc request :flash flash :session session)
      request)))

(defn- write-flash [response]
  (let [session (:session response)]
    (if (and (= nil session) (contains? response :session))
      (dissoc response :flash)
      (assoc
        (dissoc response :flash)
        :session (assoc session :_flash (:flash response))))))

(defn wrap-flash [handler]
  (fn [request]
    (let [request (read-flash request)
          response (handler request)]
      (write-flash response))))
