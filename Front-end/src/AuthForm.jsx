import React, { useState } from "react";
import "./AuthForm.css";

function AuthForm() {
  const [isSignUp, setIsSignUp] = useState(true);

  const [formData, setFormData] = useState({
    firstName: "",
    secondName: "",
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {

e.preventDefault();

    const url = isSignUp
 ? "http://localhost:8080/api/Auth/signup"
: "http://localhost:8080/api/Auth/signin";

    const bodyData = isSignUp
      ? {
       firstName: formData.firstName,
       secondName: formData.secondName,
       email: formData.email,
       password: formData.password
        }
  
: {
    
        email: formData.email,
         
        password: formData.password
        };

    try {
 const response = await fetch(url, {
 method: "POST",
 headers: {
 "Content-Type": "application/json"
        },
 body: JSON.stringify(bodyData)
      });

      const data = await response.json();
      console.log("Server response:", data);

      if (response.ok) {
        alert(isSignUp ? "Account created! You can now sign in." : "Signed in successfully!");

      
        setFormData({
   firstName: "",
   secondName: "",
   email: "",
   password: ""
        });

        
        if (isSignUp) setIsSignUp(false);

      } else {
        alert(data.message);
      }

    } catch (error) {
      
      console.error("Connection error:", error);
    }
  };

  
    return (
    <div className="auth-container">
      <div className="auth-box">

        <div className="logo">A</div>
        <h1>{isSignUp ? "Create account" : "Welcome back"}</h1>
        <p className="subtitle">{isSignUp ? "Sign up to get started" : "Sign in to continue"}</p>

        <div className="tabs">
          <button className={!isSignUp ? "active" : ""} onClick={() => setIsSignUp(false)}>Sign in</button>
          <button className={isSignUp ? "active" : ""} onClick={() => setIsSignUp(true)}>Sign up</button>
        </div>

        {message.text && (
          <div className={`message ${message.type}`}>{message.text}</div>
        )}

        <form onSubmit={handleSubmit}>
          {isSignUp && (
            <>
              <div className="field">
                <label>First name</label>
                <input type="text" name="firstName" value={formData.firstName} placeholder="e.g. Tshepo" onChange={handleChange} required />
              </div>
              <div className="field">
                <label>Last name</label>
                <input type="text" name="secondName" value={formData.secondName} placeholder="e.g. Smith" onChange={handleChange} required />
              </div>
            </>
          )}

          <div className="field">
            <label>Email address</label>
            <input type="email" name="email" value={formData.email} placeholder="you@example.com" onChange={handleChange} required />
          </div>

          <div className="field">
            <div className="password-header">
              <label>Password</label>
              {!isSignUp && <a href="/forgot-password" className="forgot-link">Forgot password?</a>}
            </div>
            <input type="password" name="password" value={formData.password} placeholder="••••••••" onChange={handleChange} required />
          </div>

          <button type="submit" className="submit-btn" disabled={loading}>
            {loading ? "Please wait..." : isSignUp ? "Create account" : "Sign in"}
          </button>
        </form>

        <p className="footer">
          {isSignUp ? "Already have an account? " : "Don't have an account? "}
          <span className="footer-link" onClick={() => setIsSignUp(!isSignUp)}>
            {isSignUp ? "Sign in" : "Sign up for free"}
          </span>
        </p>

      </div>
    </div>
  );
}

export default AuthForm;