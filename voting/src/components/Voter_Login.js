
import React, { Component ,useEffect} from 'react'
import * as ReactDOM from 'react-dom/client';
import axios from 'axios';

import  useState  from "react";
import {redirect} from 'react-router-dom';
import Voter_Dash from "./Voter_Dash";




export class Voter_Login extends Component {

  

    
    constructor(){
        super()

        
        this.state = { 
            Aadhar: '',
            
            Mobile:'+91',
            otpsendornot:false,
            isverified:false,
            // showoptslot:false
            did_click_on_OTP:false,
            OTPuser:'',
            detailsMatched:false,
            chainaddress:'',
            chainkey:'',
            

            
            


        
        };



        

        this.handleChange=this.handleChange.bind(this);

        
            
        
      }

      temp={
        tempo:''
    }



      



      Set_did_click=()=>{

        console.log("this is setting")

        const x=this.state.did_click_on_OTP

        this.setState({
            did_click_on_OTP:!x,
            
        });

      }

      

      

        



     
       handleChange= async (event)=>{

        this.setState({
            [event.target.name]:event.target.value
    
        });
    }
     
      handleSubmit = (event) => {
        
        alert('A form was submitted: ' + this.state.Aadhar+'and with mobile number :'+this.state.Mobile +" and with otp " +this.state.OTPuser);

        console.log(JSON.stringify(this.state))
        console.log(this.state.OTPuser)

        const thank = ReactDOM.createRoot(document.getElementById('temp'));

        
        
        

        axios.post('http://localhost:5000/veri', {
            OTPuser:this.state.OTPuser,
            chainaddress:this.state.chainaddress,
            chainkey:this.state.chainkey
        }).then((response)=>{
            console.log(response.data.match_or_not)
            let tempvar=response.data.match_or_not

            

            
            if(tempvar===1){
                console.log("this is inside if"+response.data.match_or_not)
                thank.render(<React.StrictMode><Voter_Dash chainaddress={this.state.chainaddress} chainkey={this.state.chainkey}/></React.StrictMode>)

            }
            else{

                alert("Incorrect OTP....Try again")

            }



        })




        event.preventDefault(); 
        
        

        




            
            

        
        



    }


    




    sendtoserver=()=>{

        alert('A form was submitted: ' + this.state.Aadhar+'and with mobile number :'+this.state.Mobile);

        // this.setState({
        //     showoptslot:true
        // })
        
        
        if(this.state.otpsendornot===false){

            

            axios.post('http://localhost:5000/auth', {
            Aadhar: this.state.Aadhar, 
            Mobile: this.state.Mobile
        }).then((response)=>{

            console.log("data checking " +response.data.matchedOrNot)

            if(!response.data.matchedOrNot){
                alert("Details not found in the DataBase")
            }
            else{
                if(this.state.did_click_on_OTP===false){
                    this.Set_did_click()
                    }
            }

        })


        
        

        this.setState({
            otpsendornot:true
        
        });

        setTimeout(() => {
            this.setState({otpsendornot:false})
            
          }, 10000);
    }
    else{

        alert('Please wait before sending another OTP')


    }
        


        




    }


   
    






render() {

    



return(

    


<div id="temp">


<div style={{fontSize:"30px"}} className='container bg-light shadow-lg rounded-5 my-5 myback2 '>{

    (!this.state.did_click_on_OTP)  &&

    <div id="not_clicked">

<div className='row p-3 my-3 display-3'>
    <p className="fw-bold text-center ">Voter Login </p>
</div>
<form onSubmit={this.handleSubmit} id="form">
<div className='row p-3 my-3'>
<div className='form-group'>
    <label htmlFor="login_aadhar" className='form-label fw-bold'>Aadhar:</label>
    <input type="text" id="login_aadhar" name='Aadhar' className='form-control form-control-lg border border-3 border-dark' placeholder='Enter your Aadhar Number ' value={this.state.Aadhar} onChange={this.handleChange} required pattern="[0-9]{12}"/>
</div></div>


<div className='row p-3 my-3'>
<div className='form-group'>
    <label htmlFor="login_mobile" className='form-label fw-bold'>Mobile Number:</label>
    <input type="tel" id="login_mobile" className='form-control form-control-lg border border-3 border-dark'  value={this.state.Mobile} onChange={this.handleChange} name="Mobile" placeholder='Enter your Mobile Number'/>
</div></div>

{/* <div className='opt-verification p-3 my-3'>{

  this.state.showoptslot && <div className='form-group'>
    <label htmlFor="login_otp" className='form-label fw-bold'>OTP</label>
    <input type="number" id="login_otp" className='form-control form-control-lg border border-3 border-dark'  onChange={this.handleChange} name="otp" placeholder='Enter your OTP'/>
</div>}





</div> */}

<div className='d-flex p-3 my-3 justify-content-center '>





<button type='button' value="otp" className='btn btn-success fw-bold mx-5' onClick={this.sendtoserver } style={{width:"120px",fontSize:'25px'}}>Send OTP</button>



{/* <button type='submit' value="Submit" className='btn btn-success fw-bold mx-5' style={{width:"120px",fontSize:'25px'}}>Submit</button> */}



</div>

</form>



</div>

}

{ (this.state.did_click_on_OTP ) &&


<div id="clicked">


<div className='row p-3 my-3 display-3'>
    <p className="fw-bold text-center ">Voter Login </p>
</div>

<div className='row p-3 my-3 display-5 fw-bold'>

    <p>Aadhar:{this.state.Aadhar}</p>
    <p>Mobile Number :{this.state.Mobile}</p>
    
</div>

<div className='row p-3 my-3  myback_warning ' style={{fontSize:"25px"}}>
    <p>check the above details</p>
    <p>Otp will be sent to the above mobile number</p>
</div>


<div className='row p-3 my-3 display-6 fw-bold'>


<label htmlFor="OTPuser" className='form-label fw-bold'>OTP:</label>
    <input type="text"  className='form-control form-control-lg border border-3 border-dark'  defaultValue={this.state.OTPuser} onChange={this.handleChange} name="OTPuser" placeholder='Enter your OTP'/>

</div>


<div className='row p-3 my-3 display-6 fw-bold'>


<label htmlFor="chainaddress" className='form-label fw-bold'>Wallet address:</label>
    <input type="text"  className='form-control form-control-lg border border-3 border-dark'  defaultValue={this.state.chainaddress} onChange={this.handleChange} name="chainaddress" placeholder='Enter your wallet address'/>

</div>


<div className='row p-3 my-3 display-6 fw-bold'>


<label htmlFor="chainkey" className='form-label fw-bold'>Wallet key:</label>
    <input type="password"  className='form-control form-control-lg border border-3 border-dark'  defaultValue={this.state.chainkey} onChange={this.handleChange} name="chainkey" placeholder='Enter your wallet key'/>

</div>










<div className='row p-3 my-3'>

<div className='d-lg-flex justify-content-around '>
<form action="">

<button type='button' value="back" className='btn btn-success fw-bold mx-5' onClick={this.Set_did_click} style={{width:"120px",fontSize:'25px'}}>back</button>
<button type='button' value="resend" className='btn btn-success fw-bold mx-5' onClick={this.sendtoserver} style={{width:"120px",fontSize:'20px'}}>Resend OTP</button>

<button type='button' value="Submit" onClick={this.handleSubmit} className='btn btn-success fw-bold mx-5' style={{width:"120px",fontSize:'25px'}}>Submit</button> 
</form></div>
</div>

</div>









}













</div>








</div>



)
}
  
}

export default Voter_Login