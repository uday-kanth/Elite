
import React, { useState } from 'react';
import axios from 'axios';


const Voter_Register=()=>{


    const [FirstName,setFirstName]=useState("")
    const [LastName,setLastName]=useState("")
    const [DOB,setDOB]=useState("")
    const [Email,setEmail]=useState("")
    const [Aadhar,setAadhar]=useState("")
    const [Mobile,setMobile]=useState("")
    const [Address,setAddress]=useState("")
    const [chainaddress,setchainaddress]=useState("")
    const [chainkey,setchainkey]=useState("")


    const putIN_DB=()=>{

        console.log(Email)


        axios.post('http://localhost:5000/putINDB', {
            FirstName:FirstName,
            LastName:LastName,
            DOB:DOB,
            Email:Email,
            Aadhar:Aadhar,
            Mobile:"+91"+Mobile,
            Address:Address,
            isRegistered:true,
            chainaddress:chainaddress,
            chainkey:chainkey,
        })




    }




return(

<div style={{fontSize:"20px"}} >

    <div className='container bg-white shadow-lg my-5 rounded-5 myback2' style={{width:"60%"}} >

    <div className='display-3 justify-content-center row'> FILL THE DETAILS</div>

    <form action="">


        <div className='row p-3'>

        <div className='col-lg my-3'>
            <input type="text" className='form-control  border border-3 border-dark'  id='fname' placeholder='First Name' value={FirstName} onChange={e=>{setFirstName(e.target.value)}} />
        </div>

        <div className='col-lg my-3'>

        
            <input type="text" className='form-control  border border-3 border-dark' id="lname"  placeholder='Last Name'  value={LastName} onChange={e=>{setLastName(e.target.value)}}   />
        </div>


        </div>


        <div className='row p-3 my-3'>

            <div className='form-group'>
                <label htmlFor="DOB" className='form-label'>Select your DOB :</label>
                <input type="date" className='border border-3 border-dark form-control ' id="DOB"   value={DOB} onChange={e=>{setDOB(e.target.value)}}   />
            </div>
        </div>







        <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="mail" className='form-label'>Email :</label>
        <input type="text" className='border border-3 border-dark form-control ' id='mail' placeholder='Enter Your Email' value={Email} onChange={e=>{setEmail(e.target.value)}} />
         </div>
         
         </div>


         <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="aadhar" className='form-label'>Aadhar :</label>
        <input type="text" className='border border-3 border-dark form-control ' id='aadhar' placeholder='Enter Your Aadhar Number'  required pattern="[0-9]{12}"  value={Aadhar} onChange={e=>{setAadhar(e.target.value)}} />
         </div>
         
         </div>


         <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="phone" className='form-label'>Mobile :</label>
        <input type="tel" className='border border-3 border-dark form-control ' id='phone' placeholder='Enter Your Phone Number' value={Mobile} onChange={e=>{setMobile(e.target.value)}} />
         </div>
         
         </div>


         <div className='row p-3 justify-content-center'>

<div className='form-group'>
<label htmlFor="chainaddress" className='form-label'>Wallet address :</label>
<input type="text" className='border border-3 border-dark form-control ' id='chainaddress' placeholder='Enter Your wallet address' value={chainaddress} onChange={e=>{setchainaddress(e.target.value)}} />
</div>

</div>



<div className='row p-3 justify-content-center'>

<div className='form-group'>
<label htmlFor="chainkey" className='form-label'>Wallet key :</label>
<input type="password" className='border border-3 border-dark form-control ' id='chainkey' placeholder='Enter Your wallet key' value={chainkey} onChange={e=>{setchainkey(e.target.value)}} />
</div>

</div>







        



         

         <div className='row my-3 p-3'>

         <div className='form-group'>
         <div className="md-form">
         <label htmlFor="address">Enter your Address:</label>
            <textarea id="address" className="md-textarea form-control border border-3 border-dark" rows="3" placeholder="Write something here..."  value={Address} onChange={e=>{setAddress(e.target.value)}}></textarea>
            </div>
            </div>


         </div>


    <div className='row my-3 p-3 justify-content-center'>
    <button className="btn btn-success " type="button" onClick={()=>{putIN_DB()}} style={{width:"120px",fontSize:"25px"}}>Submit</button>
    </div>
    












    </form>










    </div>











</div>




);



};

export default Voter_Register;