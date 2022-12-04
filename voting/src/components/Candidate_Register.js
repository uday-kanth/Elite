
import React from 'react';


const Candidate_Register=()=>{

    

return(

<div style={{fontSize:"30px"}} >

    <div className='container bg-white shadow-lg my-5 rounded-5 myback2'>

    <div className='display-3 justify-content-center row'> FILL THE DETAILS</div>

    <form action="">


        <div className='row p-3'>

        <div className='col-lg my-3'>
            <input type="text" className='form-control form-control-lg border border-3 border-dark'  id='fname' placeholder='First Name'/>
        </div>

        <div className='col-lg my-3'>

        
            <input type="text" className='form-control form-control-lg border border-3 border-dark' id="lname"  placeholder='Last Name'/>
        </div>


        </div>

        <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="mail" className='form-label'>Email :</label>
        <input type="email" className='form-control form-control-lg border border-3 border-dark' id='mail' placeholder='Enter Your Email' />
         </div>
         
         </div>


         <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="aadhar" className='form-label'>Aadhar :</label>
        <input type="text" className='form-control form-control-lg border border-3 border-dark' id='aadhar' placeholder='Enter Your Aadhar Number' required pattern="[0-9]{12}"/>
         </div>
         
         </div>


         <div className='row p-3 justify-content-center'>

            <div className='form-group'>
        <label htmlFor="phone" className='form-label'>Phone No :</label>
        <input type="tel" className='form-control form-control-lg border border-3 border-dark'  id='phone' placeholder='Enter Your Phone Number' />
         </div>
         
         </div>


         <div className='row my-3 p-3 '>
         <div className='form-group'>
            <label htmlFor="partyname" className='form-label'>Select Your Party :</label>
         <select id="partyname" name="partyname" className="form-select form-select-lg border border-3 border-dark" aria-label="">
                <option value="0">Select</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
         </select>
        </div>

         </div>

         <div className='row my-3 p-3'>

         <div className='form-group'>
         <div className="md-form">
         <label htmlFor="address">Enter your Address:</label>
            <textarea id="address" className="md-textarea form-control border border-3 border-dark" rows="3" placeholder="Write something here..."></textarea>
            </div>
            </div>


         </div>


    <div className='row my-3 p-3 justify-content-center'>
    <button className="btn btn-success text-center " type="submit" style={{width:"120px",fontSize:"25px" }}>Submit</button>
    </div>
    












    </form>










    </div>











</div>




);



};

export default Candidate_Register;