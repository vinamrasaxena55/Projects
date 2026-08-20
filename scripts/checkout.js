import { renderOrderSummary } from "./checkout/orderSummary.js";
import { renderPaymentSummary } from "./checkout/paymentSummary.js";
//import '../data/cart-class.js';
//import '../data/backend-practice.js';
import { loadProducts } from "../data/products.js";
//we have devided checkout.js to two parts so 
//we can less code in each file
//orderSummary and paymentSummary

loadProducts(()=>{//it saves these below fn in fun then load proaducts then fun is called to generate html
 renderOrderSummary();//we did so after updating run code
renderPaymentSummary();
});//giving a call back fn inside which we want to run in future
//we want load products now then once done its inside fn

// renderOrderSummary();//we did so after updating run code
// renderPaymentSummary();