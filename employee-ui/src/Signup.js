import axios from "axios";
import { useState } from "react";
import "./Signup.css"

// Design sign up page
const Signup = ({tableData, setTableData}) => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [department, setDepartment] = useState("");

    const handleSubmit = (event) => {
      event.preventDefault(); // it will not allow to refresh the page right after the form is submit
      //alert(`The name you entered was: ${name}, and the email you entered was: ${email}`)
      const saveEmployeeData = async () => {
          const requestBody = {
            "name": name,
            "email": email,
            "department": department
        }
          const response = await axios.post("http://localhost:8080/api/employee", requestBody)
          if(response.status === 200) {
            const getEmployeeResponse = axios.get("http://localhost:8080/api/employees")
            getEmployeeResponse.then(result => setTableData(result.data))
          }
        
      }
      saveEmployeeData()
    }
  
    return (
  <div className="container">
    <h2>Sign up Here</h2>
    <form onSubmit={handleSubmit}>
      <label>
        Enter your name:
        <input
          type="text"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
      </label>
      <label>
        Enter your email:
        <input
          type="text"
          value={email}
          onChange={(event) => setEmail(event.target.value)}
        />
      </label>
      <label>
        Enter your department:
        <input
          type="text"
          value={department}
          onChange={(event) => setDepartment(event.target.value)}
        />
      </label>
      <button onClick={handleSubmit}>
        Submit
      </button>
    </form>
  </div>
);

    //   <div style={{ textAlign: "center", padding: "20px", fontFamily: "Arial, sans-serif" }}>
    //   <h2>Sign up Here</h2>
    //   <form onSubmit={handleSubmit} style={{ margin: "0 auto", width: "300px" }}>
    //     <label style={{ display: "block", marginBottom: "10px" }}>
    //       Enter your name:
    //       <input
    //         type="text"
    //         value={name}
    //         onChange={(event) => setName(event.target.value)}
    //         style={{ display: "block", width: "100%", padding: "8px", marginTop: "5px" }}
    //       />
    //     </label>
    //     <label style={{ display: "block", marginBottom: "10px" }}>
    //       Enter your email:
    //       <input
    //         type="text"
    //         value={email}
    //         onChange={(event) => setEmail(event.target.value)}
    //         style={{ display: "block", width: "100%", padding: "8px", marginTop: "5px" }}
    //       />
    //     </label>
    //     <label style={{ display: "block", marginBottom: "10px" }}>
    //       Enter your department:
    //       <input
    //         type="text"
    //         value={department}
    //         onChange={(event) => setDepartment(event.target.value)}
    //         style={{ display: "block", width: "100%", padding: "8px", marginTop: "5px" }}
    //       />
    //     </label>
    //     <button
    //       onClick={handleSubmit}
          
    //       // style={{
    //       //   padding: "10px 20px",
    //       //   backgroundColor: "#4CAF50",
    //       //   color: "white",
    //       //   border: "none",
    //       //   borderRadius: "5px",
    //       //   cursor: "pointer",
    //       //   marginTop: "10px"
    //       // }}
    //     >
    //       Submit
    //     </button>
    //   </form>
    // </div>  
   // )
    }

  

export default Signup