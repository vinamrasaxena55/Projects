//creating object and putting things in it 
//instead of creating diff cart we create fn when called new cart object created
function Cart(localStorageKey){
    const cart={
     cartItems:undefined,

      loadFromStorage  (){//same as  loadFromStorage : function()
  this.cartItems=JSON.parse(localStorage.getItem(localStorageKey));//so we dont affect our orignal cart
 
  //products in products.js
  if(!this.cartItems){
    this.cartItems=  [{
   productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
   quantity: 2,
   deliveryOptionId:'1'
},
{
  productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
   quantity: 1,//giving some default values
   deliveryOptionId:'2'//from deliveryOptions 
}
  ];
  }


},

 saveToStorage(){
  localStorage.setItem(localStorageKey,JSON.stringify(this.cartItems));
  //remember local storage can only store strings
},

 addToCart(productId){
 let matchingItem;
   this.cartItems.forEach((cartItem)=>{
        if(productId===cartItem.productId){
               //if item already in cart
               matchingItem=cartItem;
        }
   });

   if(matchingItem){//boolean type if there true 
           matchingItem.quantity +=1;
   }
   else{
      this.cartItems.push({
    productId : productId,
    quantity:1,
    deliveryOptionId:'1'
   });
   }
   this.saveToStorage();
},
  removeFromCart(productId){
   
let newCart = [];
    
      this.cartItems.forEach((cartItem)=>{
        if(cartItem.productId !==productId){
           newCart.push(cartItem);
        }
      });
      this.cartItems=newCart;//replace the cart
      this.saveToStorage();
},

updateDeliveryOption(productId,deliveryOptionId){
 /
  let matchingItem;
    this.cartItems.forEach((cartItem)=>{
          if(productId===cartItem.productId){
              
                matchingItem=cartItem;
          }
    });
 
  matchingItem.deliveryOptionId = deliveryOptionId;

  this.saveToStorage();
}
};
    return cart;
}
// const cart={
//      cartItems:undefined,//we cant define let our export inside object,making cart object and 
//      //defining its parts like cartItems

//       loadFromStorage  (){//same as  loadFromStorage : function()
//   this.cartItems=JSON.parse(localStorage.getItem('cart-oop'));//so we dont affect our orignal cart
// //converting from string back to array
// //we are just saving id, which we can use to search 
//   //products in products.js
//   if(!this.cartItems){//if cart empty put some default values
//     this.cartItems=  [{
//    productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
//    quantity: 2,
//    deliveryOptionId:'1'
// },
// {
//   productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
//    quantity: 1,//giving some default values
//    deliveryOptionId:'2'//from deliveryOptions 
// }
//   ];
//   }

// //now this variable can be used outside this file
// },

//  saveToStorage(){
//   localStorage.setItem('cart-oop',JSON.stringify(this.cartItems));
//   //remember local storage can only store strings
// },

//  addToCart(productId){
//  let matchingItem;
//    this.cartItems.forEach((cartItem)=>{
//         if(productId===cartItem.productId){
//                //if item already in cart
//                matchingItem=cartItem;
//         }
//    });

//    if(matchingItem){//boolean type if there true 
//            matchingItem.quantity +=1;
//    }
//    else{
//       this.cartItems.push({
//     productId : productId,
//     quantity:1,
//     deliveryOptionId:'1'
//    });
//    }
//    this.saveToStorage();//whenever saved store in local storage, access fn inside object
// },
//   removeFromCart(productId){
   
// let newCart = [];
//       //create new array
//       //loop through cart
//       //add each product to new array, except for this productid  
//       this.cartItems.forEach((cartItem)=>{
//         if(cartItem.productId !==productId){
//            newCart.push(cartItem);
//         }
//       });
//       this.cartItems=newCart;//replace the cart
//       this.saveToStorage();
// },

// updateDeliveryOption(productId,deliveryOptionId){
//  //loop through cart and find product
//  //update delivery optionId of product

//   let matchingItem;
//     this.cartItems.forEach((cartItem)=>{
//           if(productId===cartItem.productId){
//                 //if item already in cart
//                 matchingItem=cartItem;
//           }
//     });
//   //updating delivery id 
//   matchingItem.deliveryOptionId = deliveryOptionId;

//   this.saveToStorage();
// }

// };

//we used this bcz if cart name changes to anything else it wont work
//this refers to object cart or a new name if changed




// cart.loadFromStorage();//bcz loadfromstorage moved inside cart
// //console.log(cart);

// //this is in console
// // Object
// // addToCart
// // : 
// // addToCart(productId){ let matchingItem; this.cartItems.forEach((cartItem)=> {…}
// // cartItems
// // : 
// // (2) [{…}, {…}]
// // loadFromStorage
// // : 
// // ƒ loadFromStorage()
// // removeFromCart
// // : 
// // removeFromCart(productId){ let newCart = []; //create new array //loop through cart //add each product to new array, except for this productid this.cartItems.forEach((cartItem)=> {…}
// // saveToStorage
// // : 
// // ƒ saveToStorage()
// // updateDeliveryOption
// // : 
// // updateDeliveryOption(productId,deliveryOptionId){ //loop through cart and find product //update delivery optionId of product let matchingItem; this.cartItems.forEach((cartItem)=> {…}
// // [[Prototype]]
// // : 
// // Object


// // cart.addToCart('54e0eccd-8f36-462b-b68a-8182611d9add');
// // console.log(cart);//now lenth increase showing work same as before butusing oop

 



// //++++++++++++++++++++++++++++++++++new cart+++++++++++++++++++++++++++++

// // const businesscart={
// //      cartItems:undefined,//we cant define let our export inside object,making cart object and 
// //      //defining its parts like cartItems

// //       loadFromStorage  (){//same as  loadFromStorage : function()
// //   this.cartItems=JSON.parse(localStorage.getItem('cart-business'));//so we dont affect our cart-oop and dont conflict

// //   if(!this.cartItems){//if cart empty put some default values
// //     this.cartItems=  [{
// //    productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
// //    quantity: 2,
// //    deliveryOptionId:'1'
// // },
// // {
// //   productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
// //    quantity: 1,//giving some default values
// //    deliveryOptionId:'2'//from deliveryOptions 
// // }
// //   ];
// //   }

// // //now this variable can be used outside this file
// // },

// //  saveToStorage(){
// //   localStorage.setItem('cart-business',JSON.stringify(this.cartItems));
// //   //remember local storage can only store strings
// // },

// //  addToCart(productId){
// //  let matchingItem;
// //    this.cartItems.forEach((cartItem)=>{
// //         if(productId===cartItem.productId){
// //                //if item already in cart
// //                matchingItem=cartItem;
// //         }
// //    });

// //    if(matchingItem){//boolean type if there true 
// //            matchingItem.quantity +=1;
// //    }
// //    else{
// //       this.cartItems.push({
// //     productId : productId,
// //     quantity:1,
// //     deliveryOptionId:'1'
// //    });
// //    }
// //    this.saveToStorage();//whenever saved store in local storage, access fn inside object
// // },
// //   removeFromCart(productId){
   
// // let newCart = [];
     
// //       this.cartItems.forEach((cartItem)=>{
// //         if(cartItem.productId !==productId){
// //            newCart.push(cartItem);
// //         }
// //       });
// //       this.cartItems=newCart;//replace the cart
// //       this.saveToStorage();
// // },

// // updateDeliveryOption(productId,deliveryOptionId){


// //   let matchingItem;
// //     this.cartItems.forEach((cartItem)=>{
// //           if(productId===cartItem.productId){
// //                 //if item already in cart
// //                 matchingItem=cartItem;
// //           }
// //     });
// //   //updating delivery id 
// //   matchingItem.deliveryOptionId = deliveryOptionId;

// //   this.saveToStorage();
// // }

// // };
// businesscart.loadFromStorage();

// console.log(cart);
// console.log(businesscart);
// //shows us we have 2 carts


const cart=Cart('cart-oop');
const businesscart=Cart('cart-buisness');
//passing parameter LocalStorageKey  so where they have object








