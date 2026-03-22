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

  <div className="tabs">
 <button
      className={!isSignUp ? "active" : ""}
            onClick={() => setIsSignUp(false)}
      >
            Sign In
    </button>

 <button
     className={isSignUp ? "active" : ""}
       onClick={() => setIsSignUp(true)}
          >
            Sign Up
   </button>
        </div>

    <form onSubmit={handleSubmit}>

          {isSignUp && (
            <>
    <input
         type="text"
         name="firstName"
          value={formData.firstName}
         placeholder="First name"
 onChange={handleChange}
      />

 <input
       type="text"
       name="secondName"
       value={formData.secondName}
       placeholder="Second name"
  onChange={handleChange}
              />
            </>
          )}

  <input
 type="email"
   name="email"
            value={formData.email}
  placeholder="Enter your email"
   onChange={handleChange}
   />

   <input
            type="password"
     name="password"
            value={formData.password}
    placeholder="Enter your password"
            onChange={handleChange}
          />

          <button className="submit-btn">
      {isSignUp ? "SIGN UP" : "SIGN IN"}
          </button>

        </form>
   </div>
    </div>
  );
}

export default AuthForm;