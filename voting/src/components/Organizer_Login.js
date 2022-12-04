
import React, { useState } from 'react';
import axios from 'axios';
import * as ReactDOM from 'react-dom/client';
import Organizer_dash from './Organizer_dash';
const Organizer_Login=()=>{



    const [chainaddress,setchainaddress]=useState("")
    const [chainkey,setchainkey]=useState("")
    



    function orgdash(){

        axios.post('http://localhost:5000/org', {
            chainaddress:chainaddress,
            chainkey:chainkey,
            mode:-1,
            
        })


        const thank = ReactDOM.createRoot(document.getElementById('orglog'));

        thank.render(<React.StrictMode><Organizer_dash   chainaddress={chainaddress} chainkey={chainkey}   /></React.StrictMode>);



    }





return(

<div >


<div className="container bg-white my-5 p-3 rounded-5 myback2" id="orglog">


<div >
    <form action="">

    <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="chainaddress" className='form-label'>Wallet address :</label>
        <input type="text" className='border border-3 border-dark form-control ' id='chainaddress' placeholder='Enter Your Wallet address' value={chainaddress} onChange={e=>{setchainaddress(e.target.value)}} />
         </div>
         
         </div>


         <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="chainkey" className='form-label'>Wallet Key :</label>
        <input type="text" className='border border-3 border-dark form-control ' id='chainkey' placeholder='Enter Your Wallet key' value={chainkey} onChange={e=>{setchainkey(e.target.value)}} />
         </div>
         
         </div>


         <div className='row my-3 p-3 justify-content-center'>
    <button className="btn btn-success " type="button" onClick={()=>{orgdash()}} style={{width:"120px",fontSize:"25px"}}>Submit</button>
    </div>











    </form>


</div>




</div>







</div>










);







};

export default Organizer_Login;