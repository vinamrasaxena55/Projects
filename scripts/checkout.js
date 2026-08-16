import { cart , removeFromCart, updateDeliveryOption} from "../data/cart.js";
import { products } from "../data/products.js";
import { formatCurrency } from "./utils/money.js";//single . bcz inside script folder
import {hello} from 'https://unpkg.com/supersimpledev@1.0.1/hello.esm.js';//external library
import dayjs from 'https://unpkg.com/supersimpledev@8.5.0/dayjs/esm/index.js';//without {} inbuilt external lib
import { deliveryOptions } from "../data/deliveryOptions.js";


// hello();
// console.log(dayjs()); these are from external library

// const today=dayjs();
// today.add(7,'days');//add 7 days to todays date
// deliveryDate.format('dddd,MMMM D ');//format of day then month then date

let cartSummaryHtml='';

cart.forEach((cartItem)=>{
  //generating html of checkout using js
    const productId=cartItem.productId;//iterating 
    let matchingProduct;

    products.forEach((product)=>{
      if(product.id === productId){
        matchingProduct=product;//now we have access to img etc
      }
    });
   // js-cart-item-container-${matchingProduct.id    to update html after deletion
 

           const deliveryOptionId=cartItem.deliveryOptionId;

           let deliveryOption;

            deliveryOptions.forEach((option)=>{
               if(option.id=== deliveryOptionId){
                deliveryOption=option;
               }
            });
            const today=dayjs();
            const deliveryDate=today.add(
         deliveryOption.deliveryDays,
         'days'// date according to us
          );
          const dateString =deliveryDate.format(
           'dddd, MMMM D'
          );

          cartSummaryHtml += `
          <div class="cart-item-container 
           js-cart-item-container-${matchingProduct.id}">

                <div class="delivery-date">
                Delivery date: ${dateString}
                </div>

                <div class="cart-item-details-grid">
                <img class="product-image"
                    src="${matchingProduct.image}">

                <div class="cart-item-details">
                    <div class="product-name">
                   ${matchingProduct.name}
                    </div>
                    <div class="product-price">
                    $${formatCurrency(matchingProduct.priceCents)}
                    </div>
                    <div class="product-quantity">
                    <span>
                        Quantity: <span class="quantity-label">${cartItem.quantity}</span>
                    </span>
                    <span class="update-quantity-link link-primary">
                        Update
                    </span>
                    <span class="delete-quantity-link link-primary js-delete-link"
                    data-product-id="${matchingProduct.id}">
                        Delete
                    </span>
                    </div>
                </div>

                <div class="delivery-options">
                    <div class="delivery-options-title">
                    Choose a delivery option:
                    </div>
                   ${deliveryOptionsHTML(matchingProduct,cartItem)}
                </div>
                </div>
            </div>
            `;
});

//we changed name in radio to ${matchingProduct.id} istead of dilevery-option-1 bcz it will 
//enable us to choose diff option if name differs
// ${deliveryOptionsHTML(matchingProduct)}  we passed argument bcz fn doesnt have matching product



function deliveryOptionsHTML(matchingProduct,cartItem){
    let html='';
    //loop through deliveryOptions
    //for each option . generate some HTML
    //Combine Html together
    deliveryOptions.forEach((deliveryOption)=>{
          const today=dayjs();
          const deliveryDate=today.add(
         deliveryOption.deliveryDays,
         'days'// date according to us
          );
          const dateString =deliveryDate.format(
           'dddd, MMMM D'
          );
        const priceString=deliveryOption.priceCents
        ===0 
        ? 'FREE'
        : `$${formatCurrency(deliveryOption.priceCents)}`;//`` to read deliveryOption.priceCents 


        const isChecked=deliveryOption.id === cartItem.deliveryOptionId;

          html += `
                <div class="delivery-option js-delivery-option"
                data-product-id="${matchingProduct.id}"
                data-delivery-option-id="${deliveryOption.id}">
                    <input type="radio"
                    ${isChecked ? 'checked' : ''}
                        class="delivery-option-input"
                        name="${matchingProduct.id}">
                    <div>
                        <div class="delivery-option-date">
                        ${dateString}
                        </div>
                        <div class="delivery-option-price">
                        ${priceString} - Shipping
                        </div>
                    </div>
                    </div>
                   
                    `;
                    console.log(dayjs().format('dddd, MMMM D, YYYY'));
    });
    return html;
}


//data-product-id="${matchingProduct.id}"
  //data-delivery-option-id="${deliveryOption.id}  used for updating delivery   



document.querySelector('.js-order-summary')
.innerHTML=cartSummaryHtml;//replacing html with html using js


//made data-product-link to remove and match data
document.querySelectorAll('.js-delete-link')
   .forEach((link)=>{//making delete button interactive using eventlistner
      link.addEventListener('click',()=>{
 //on clicking  print delete
 const productId=link.dataset.productId;
 removeFromCart(productId);

     const container=document.querySelector(
        `.js-cart-item-container-${productId}`//used `` here instead of '' bcz it will read productId
     );
     container.remove();//remove from web page
      });
   });

document.querySelectorAll('.js-delivery-option')
  .forEach((element)=>{
   element.addEventListener('click',()=>{
    const {productId,deliveryOptionId}=element.dataset;//deconstructor
     updateDeliveryOption(productId,deliveryOptionId);
   });
  });