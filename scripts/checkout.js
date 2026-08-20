import { renderOrderSummary } from "./checkout/orderSummary.js";
import { renderPaymentSummary } from "./checkout/paymentSummary.js";
//import '../data/cart-class.js';
//import '../data/backend-practice.js';
import { loadCart } from "../data/cart.js";
import { loadProducts, loadProductsFetch } from "../data/products.js";
//we have devided checkout.js to two parts so 
//we can less code in each file
//orderSummary and paymentSummary



// new Promise((resolve)=>{
//    console.log('start promise');//its inbuilt function which run immediately
//    //resolve is similar to jasmine done and let us control when to go to next step
//    loadProducts(()=>{
//     console.log('finished loading');
// resolve();//waited till finished loading
//    });
// }).then(()=>{
//   console.log('next-step');
// })
//oreder of running
//1- start promise  2- loadProducts  3-finished loading  4-next step


//in this promise act as component as array and is part of Promise All
Promise.all([
//     new Promise((resolve)=>{
//    loadProductsFetch(()=>{
// resolve('value1');//waited till finished loading
//    });
//    }),
  loadProductsFetch(),
   new Promise((resolve)=>{
       loadCart(()=>{
        resolve();//when finished running fn inside load cart
       });
    })

]).then((values)=>{
    console.log(values);
     renderOrderSummary();
    renderPaymentSummary();
});






//promise help us keep our code flat prevent nesting and make it readable
/*
new Promise((resolve)=>{
  
   loadProducts(()=>{
resolve('value1');//waited till finished loading
   });
}).then((value)=>{//2nd step, whatever we give value in resolve it saved in this parameter
    console.log(value);
    return new Promise((resolve)=>{
       loadCart(()=>{
        resolve();//when finished running fn inside load cart
       });
    });
 
}).then(()=>{//next step after loading cart,third step
    renderOrderSummary();
    renderPaymentSummary();
});
//in above code we waited for products till they load then called our functions for html code
//we used this instead our previous way because
//function inside function cause nesting
*/



// loadProducts(()=>{//it saves these below fn in fun then load proaducts then fun is called to generate html
 
//     loadCart(()=>{
//      renderOrderSummary();//we did so after updating run code
// renderPaymentSummary();
//     });//products first called by bakend by products then backend call 
    //of cart add them to cart then we generate html using fns

 
//});//giving a call back fn inside which we want to run in future
//we want load products now then once done its inside fn

// renderOrderSummary();//we did so after updating run code
// renderPaymentSummary();