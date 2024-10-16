import axios from "axios";
import { useEffect, useState } from "react";

// Show new employee data without refreshing and show the department

function Table({tableData, setTableData}) {
    
    useEffect(() => {
        const response = axios.get("http://localhost:8080/api/employees")
                response.then(result => setTableData(result.data)) // if promise gets fulfilled (whatever we are requesting get fulfilled) then put response in result
    }, [])
    return (
        <div className="Table">
            {
                <table>
                    <thead>
                        <tr>
                            <td>
                                Name
                    </td>
                            <td>
                                Email
                    </td>
                    <td>
                                Department
                    </td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            tableData && tableData.map((row) => <tr>
                                <td>
                                    {row.name}
                                </td>
                                <td>
                                    {row.email}
                                </td>
                                <td>
                                    {row.department}
                                </td>
                            </tr>)
                        }

                    </tbody>
                </table>
            }

        </div>
    );
}

export default Table;