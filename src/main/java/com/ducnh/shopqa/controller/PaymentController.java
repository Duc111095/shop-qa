package com.ducnh.shopqa.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducnh.shopqa.entity.Cart;
import com.ducnh.shopqa.entity.CartProduct;
import com.ducnh.shopqa.entity.Payment;
import com.ducnh.shopqa.service.CartProductService;
import com.ducnh.shopqa.service.CartService;
import com.ducnh.shopqa.service.PaymentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartProductService cartProductService;

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @SuppressWarnings("unchecked")
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> createPayment(HttpEntity<String> httpEntity) {
        String jsonBody = httpEntity.getBody();
        JSONObject jsonObject = new JSONObject(jsonBody);
        System.out.println(jsonObject);
        Payment payment = new Payment();
        String cartId = cartService.addToCart(12L);
        List<Object> cartProducts = jsonObject.getJSONArray("cart").toList();
        for (Object cartProduct : cartProducts) {
            
            Map<String, Object> cartProductJson = (Map<String, Object>) cartProduct;
            CartProduct cartProductEntity = new CartProduct();
            cartProductEntity.setCartId(cartId);
            cartProductEntity.setProductId(Long.parseLong(cartProductJson.get("id").toString()));
            cartProductEntity.setQuantity((int)cartProductJson.get("quantity"));
            cartProductService.addProductToCart(cartProductEntity);
        }
        payment.setCartId(cartId);
        payment.setFullName(jsonObject.getString("fullName"));
        payment.setEmail(jsonObject.getString("email"));
        payment.setAddress(jsonObject.getString("address"));
        payment.setPhone(jsonObject.getString("phone"));
        payment.setTotalPrice(jsonObject.getDouble("totalPrice"));
        payment.setPaymentMethod(jsonObject.getString("paymentMethod"));
        payment.setNotes(jsonObject.getString("notes"));
        paymentService.createPayment(payment);
        return ResponseEntity.ok(payment);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        paymentService.updatePayment(payment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentById(@PathVariable Long id) {
        paymentService.deletePaymentById(id);
        return ResponseEntity.ok().build();
    }
}
