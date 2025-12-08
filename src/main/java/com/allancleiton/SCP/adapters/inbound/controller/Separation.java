package com.allancleiton.SCP.adapters.inbound.controller;

import javafx.scene.control.Button;

public class Separation {
    String orderCharge; Button btnAction1; Button btnAction2;

    public Separation(String orderCharge, Button btnAction1, Button btnAction2) {
        this.orderCharge = orderCharge;
        this.btnAction1 = btnAction1;
        this.btnAction2 = btnAction2;
    }
}
