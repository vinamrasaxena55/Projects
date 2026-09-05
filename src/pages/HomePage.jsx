//we moved everything from starting code and moved to jsx
import axios from 'axios';
import { useEffect, useState } from 'react';
import './HomePage.css';
import { Header } from '../components/Header';
import { formatMoney } from '../utils/money';

export function HomePage({cart}) {//given in App

//updater fn the second arg lets us pdate value
 const [products, setProducts]=useState([]);

 //in this case 'products' and regenarates HTML
 //after  getting response frm backend we will give it here


//using axios.get instead of fetch it is better 
  useEffect(()=>{//useEffect lets us control when some code runs
         
            axios.get('/api/products')
          .then((response)=>{
            console.log(response.data);
            setProducts(response.data);

        //instead of using http://localhost:3000 we put it in vite.config
          

          });//if dependency array is empty it means the 
          //above code will run once when component created
  },[]);//what happens is setProducts get response from backend and get data 
  //then setProducts update products then this products is used to generate html




    //  axios.get('http://localhost:3000/api/products')
    // .then((response)=>{
    //    console.log(response.data);//did not need extra then as it returned array
    // });








  //response in .then store response of fetch 
  // fetch('http://localhost:3000/api/products')
  // .then((response)=>{
  //    return  response.json();
  // }).then((data)=>{//response.json stored in data
  //        console.log(data);
  // });
  // .then((response)=>{
  //             //  console.log(response);//return response in console
  //             //json gives data attached to response
  //             //.then() used with response.json as it is also asynchronus
  //             response.json().then((data)=>{
  //                  console.log(data);//gives json body
  //             });
  // });





//make sure name of data in useState 'products' should match 
//name in html products.map()
  return (
    //.map() takes value and maps it o new value 
    //we are looping through each product and generating its HTML
    //when we loop we kive key which keep track changes
    
    //cart passed in  Header bcz cart is in header
    <>
      <Header  cart={cart}/>

      <div className="home-page">
        <div className="products-grid">
          {products.map((product) => {
            return (
            <div key={product.id} className="product-container">
              <div className="product-image-container">
                <img className="product-image"
                  src={product.image} />
              </div>

              <div className="product-name limit-text-to-2-lines">
                {product.name}
              </div>

              <div className="product-rating-container">
                <img className="product-rating-stars"
                  src={`images/ratings/rating-${product.rating.stars*10}.png`} />
                <div className="product-rating-count link-primary">
                  {product.rating.count}
                </div>
              </div>

              <div className="product-price">
                {formatMoney(product.priceCents)}
              </div>

              <div className="product-quantity-container">
                <select>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                  <option value="8">8</option>
                  <option value="9">9</option>
                  <option value="10">10</option>
                </select>
              </div>

              <div className="product-spacer"></div>

              <div className="added-to-cart">
                <img src="images/icons/checkmark.png" />
                Added
              </div>

              <button className="add-to-cart-button button-primary">
                Add to Cart
              </button>
            </div>
            );
          })}
         
        </div>
      </div>
    </>
  );
}