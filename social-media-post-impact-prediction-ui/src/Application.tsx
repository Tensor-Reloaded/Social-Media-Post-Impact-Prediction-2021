import React from "react";
import "./Application.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./pages/Home";
import GetPrediction from "./pages/GetPrediction";
import PredictionsManagement from "./pages/PredictionsManagement";
import CustomNavbar from "./components/CustomNavbar";
import LoginError from "./pages/LoginError";
import { getPredictions } from "./services/PredictionService";
import { AuthenticationProvider} from "./services/AuthorizationService";
import OAuthRedirect from "./pages/OAuthRedirect";

export default function Application() {
  
  return (
    <AuthenticationProvider>
      <Router>
        <Switch>
          <Route path="/login-error" render={() => <LoginError />} />
          <>
            <CustomNavbar />
            <Route path="/" exact render={() => <Home />} />
            <Route path="/get-prediction" render={() => <GetPrediction />} />
            <Route
              path="/predictions-management"
              render={() => (
                <PredictionsManagement predictions={[]} />
              )}
            />
            <Route path="/oauth_redirect" render={() => <OAuthRedirect/>} />
          </>
        </Switch>
      </Router>
    </AuthenticationProvider>
  );
}
