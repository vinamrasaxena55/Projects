import { renderOrderSummary } from "./checkout/orderSummary.js";
import { renderPaymentSummary } from "./checkout/paymentSummary.js";

import { loadCart } from "../data/cart.js";
import { loadProducts, loadProductsFetch } from "../data/products.js";


async function loadPage(){
    try{
        //throw 'error1';
     console.log('load page');
    await loadProductsFetch();


 const value=   await new Promise((resolve,reject)=>{
       loadCart(()=>{
        resolve('value3');
       });
    });
} catch(error){
  console.log('Unexpected error. Please try again later');
}
    renderOrderSummary();
    renderPaymentSummary();
    return 'value2';
}
loadPage();








