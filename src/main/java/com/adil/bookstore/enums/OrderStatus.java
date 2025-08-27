package com.adil.bookstore.enums;

public enum OrderStatus {
    PENDING,    // Sifariş yaradılıb, ödəniş gözləyir
    PAID,       // Ödəniş tamamlandı
    CANCELLED,  // Sifariş ləğv edildi
    SHIPPED,    // Sifariş göndərildi
    DELIVERED   // Sifariş istifadəçiyə çatdırıldı
}