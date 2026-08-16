import { cart } from "../data/cart";
import { products } from "../data/products";
import { formatCurrency } from "./utils/money";//single . bcz inside script folder

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
   
 
          cartSummaryHtml += `
          <div class="cart-item-container">

                <div class="delivery-date">
                Delivery date: Tuesday, June 21
                </div>

                <div class="cart-item-details-grid">
                <img class="product-image"
                    src="${matchingProduct.image}">

                <div class="cart-item-details">
                    <div class="product-name">
                   ${matchingProduct.name}
                    </div>
                    <div class="product-price">
                    ${formatCurrency(matchingProduct.priceCents)}
                    </div>
                    <div class="product-quantity">
                    <span>
                        Quantity: <span class="quantity-label">${cartItem.quantity}</span>
                    </span>
                    <span class="update-quantity-link link-primary">
                        Update
                    </span>
                    <span class="delete-quantity-link link-primary">
                        Delete
                    </span>
                    </div>
                </div>

                <div class="delivery-options">
                    <div class="delivery-options-title">
                    Choose a delivery option:
                    </div>
                    <div class="delivery-option">
                    <input type="radio" checked
                        class="delivery-option-input"
                        name="delivery-option-${matchingProduct.id}">
                    <div>
                        <div class="delivery-option-date">
                        Tuesday, June 21
                        </div>
                        <div class="delivery-option-price">
                        FREE Shipping
                        </div>
                    </div>
                    </div>
                    <div class="delivery-option">
                    <input type="radio"
                        class="delivery-option-input"
                        name="${matchingProduct.id}">
                    <div>
                        <div class="delivery-option-date">
                        Wednesday, June 15
                        </div>
                        <div class="delivery-option-price">
                        $4.99 - Shipping
                        </div>
                    </div>
                    </div>
                    <div class="delivery-option">
                    <input type="radio"
                        class="delivery-option-input"
                        name="${matchingProduct.id}">
                    <div>
                        <div class="delivery-option-date">
                        Monday, June 13
                        </div>
                        <div class="delivery-option-price">
                        $9.99 - Shipping
                        </div>
                    </div>
                    </div>
                </div>
                </div>
            </div>
            `;
});

//we changed name in radio to ${matchingProduct.id} istead of dilevery-option-1 bcz it will 
//enable us to choose diff option if name differs

document.querySelector('.js-order-summary')
.innerHTML=cartSummaryHtml;//replacing html with html using js

console.log(cartSummaryHtml);
