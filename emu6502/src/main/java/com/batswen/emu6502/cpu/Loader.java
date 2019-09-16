/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.batswen.emu6502.cpu;

/**
 *
 * @author Swen
 */
public class Loader {
    private final CPU cpu;
    public Loader(CPU cpu) {
        this.cpu = cpu;
    }
    public void load(String program) {
        int addr, b;
        addr = Integer.parseInt(program.substring(0, 4), 16);
        program = program.substring(4);
        for (int i = 0; i < program.length(); i += 2) {
            //System.out.println("Poking "+String.format("%04X",addr)+": "+String.format("%02X",Integer.parseInt(program.substring(i, i + 2), 16)));
            cpu.pokeByte(addr++, Integer.parseInt(program.substring(i, i + 2), 16));
        }
    }
}
