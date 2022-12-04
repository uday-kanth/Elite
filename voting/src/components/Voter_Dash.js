import React, { Component } from 'react';
import  {useState}  from "react";
import Corousel from 'react-elastic-carousel';

import CourItem from './CourItem';

import axios from 'axios';
const Voter_Dash=(props)=> {


  

    
let breakPoint=[


{width:1,itemsToShow:1},
{width: 550,itemsToShow:2},
{width: 768,itemsToShow:3},
{width: 1200,itemsToShow:4}


];





let  items=[
  {id:0 , url:"./images/nota.jpg" ,party:"NOTA" , motto:"NOTA" ,Cname:"NOTA" },
  {id:1 , url:"./images/logo2.png" ,party:"A" , motto:"this is my motto" ,Cname:"u" },
  {id:2 , url:"./images/logo1.png",party:"B" , motto:"this is my motto" ,Cname:"v"},
  {id:3 , url:"./images/logo3.png",party:"C", motto:"this is my motto" ,Cname:"w"},
  {id:4 , url:"./images/logo2.png",party:"D", motto:"this is my motto" ,Cname:"x" },
  {id:5 , url:"./images/logo1.png",party:"E", motto:"this is my motto" ,Cname:"y" },
  {id:6 , url:"./images/logo3.png",party:"F", motto:"this is my motto" ,Cname:"z" }





  ]


  const [choice,setchoice]=useState(0);


  function do_vote(para){

    axios.post('http://localhost:5000/org', {
            
            chainaddress:props.chainaddress,
            chainkey:props.chainkey,
            mode:4,
            choice:para,
        })




  }



    


   
    return (
        <div className='container-fluid '>


        <div className='row p-3 bg-light my-3 display-6 fw-bold justify-content-center shadow-lg'>
            Select a candidate to vote

            

            


        </div>

        <div className='row p-3'>

        <div className='container-fluid' style={{width:"80%"}}>
        

        
        <Corousel breakPoints={breakPoint}>
        
        {items.map(item=>
        <div className='container' key={item.id}>


        <div className="card" style={{width :"18rem"}}>
        <img src={require(`${item.url}`)} alt="" height={"200px"} /> 
  <div className="card-body">
    <h5 className="card-title">{item.Cname}</h5>
    <p className="card-text">{item.motto}</p>
  </div>
  <ul className="list-group list-group-flush">
    <li className="list-group-item"> <p className='fw-bold'> PartName : {item.party}</p></li>
    <li className="list-group-item"><p className='fw-bold'> PartName : {item.party}</p></li>
    <li className="list-group-item"><button type='button' className='btn btn-lg btn-outline-dark ' onClick={()=>{setchoice(item.id)}}  > Select</button></li>
  </ul>
  
</div>
        
         
         
         
         </div>)}




        </Corousel>


        </div>
</div>

<div className='row m-5 '>
  <div className='container bg-light fw-bold rounded-4 shadow-lg  '>
  <div className='row p-1 m-5 justify-content-center' style={{fontSize:"30px" , fontFamily:"monospace" }}>
            you have selected : {items[choice].Cname}

          </div>

  <div className='row p-1 m-5 justify-content-center'>

          <button type='submit' className='btn btn-lg btn-outline-success fw-bold' style={{width:'150px' , fontSize:"25px"}} onClick={()=>{do_vote(choice)}}>Submit</button>

  </div>        


  </div>
</div>

        
          

        
        
        
        
        

        
        
        </div>
    )
  
}

export default Voter_Dash;


