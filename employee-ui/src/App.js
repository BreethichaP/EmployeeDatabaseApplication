import axios from 'axios';
import { useEffect, useState } from 'react';
import logo from './logo.svg';
import Signup from './Signup';
import Table from './Table';


function App() {
  const [tableData, setTableData] = useState([])
  //JavaScript Logic is written here luke what happens if a button is clicked
  return (
    // Everything I want to show on the screen
    // put the table data stuff in another component like sign up
    <div className="App">
       <Signup tableData = {tableData} setTableData = {setTableData}/>
       {/* <Table tableData = {tableData} setTableData = {setTableData}/> */}
    </div>
  );
}

export default App;
