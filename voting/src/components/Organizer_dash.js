

import React, { useState } from 'react';
import axios from 'axios';
import * as ReactDOM from 'react-dom/client';

 const Organizer_dash=(props)=> {

  const [winner,setwinner]=useState("")
  const [votes,setvotes]=useState(0)
    


     function get_Result(){

         axios.post('http://localhost:5000/org', {
            chainaddress:props.chainaddress,
            chainkey:props.chainkey,
            mode:3,
            
        }).then(async(res)=>{

          console.log(res.data.winner);
         await setwinner(res.data.winner);
          await setvotes(res.data.votes);

          // let x=document.getElementById("winner");
          // x.innerHTML="winner : "+res.data.winner+" votes: "+res.data.votes;

          let x=document.getElementById("winner");
          x.innerHTML='';
            let div1=document.createElement('div');
            let p1=document.createElement('p');
            p1.innerHTML='Winner : '+res.data.winner;
            let p2=document.createElement('p');
            p2.innerHTML='votes : '+res.data.votes;

            div1.appendChild(p1);
            div1.appendChild(p2);
            x.appendChild(div1);

          

        })

        alert("the results are calculated");

    }



    function start_voting(){

        console.log("started");

       axios.post('http://localhost:5000/org', {
            chainaddress:props.chainaddress,
            chainkey:props.chainkey,
            mode:1,
            
        })

        alert("the voting started");

    }


   function end_voting(){

     axios.post('http://localhost:5000/org', {
            chainaddress:props.chainaddress,
            chainkey:props.chainkey,
            mode:2,
            
        })

        alert("the voting ended");

    }


 




  return (
    <div>

    <div className='container my-3'>


    <div className='row  p-5 d-flex justify-content-center text-center '><button type='button' className='btn btn-lg btn-outline-dark fw-bold border-4 border border-dark' style={{ width:"250px", wordWrap:"break-word"}} onClick={()=>{start_voting()}}>Start Voting</button></div>
    
    <div className='row  p-5 d-flex justify-content-center text-center '><button type='button' className='btn btn-lg btn-outline-dark fw-bold border-4 border border-dark' style={{ width:"250px", wordWrap:"break-word"}} onClick={()=>{end_voting()}}>End Voting</button></div>
    
    <div className='row  p-5 d-flex justify-content-center text-center '><button type='button' className='btn btn-lg btn-outline-dark fw-bold border-4 border border-dark' style={{ width:"250px", wordWrap:"break-word"}} onClick={()=>{get_Result()}}>Get Result</button></div>
    <div id='winner' className='row p-1 d-flex justify-content-center text-center bg-info display-3' ></div>
    
    
    </div>







    </div>
  );
}




export default Organizer_dash;
