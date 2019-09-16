package com.batswen.emu6502;

import com.batswen.emu6502.cpu.CPU;
import com.batswen.emu6502.cpu.Loader;

public class Run {
    public static void main(String[] args) {
        String program = "2000200030a902a20a9d0004ca10faa00391a088d0fb00";
        CPU cpu = new CPU();
        Loader loader = new Loader(cpu);
        loader.load("fffc0020");
        loader.load("00a00005");
        loader.load(program);
        loader.load("3000a934ff01a932ff0160");
        cpu.reset();
        for (int i = 0; i < 100; i++) {
            cpu.execute();
        }        
        java.awt.EventQueue.invokeLater(() -> {
            new Win(cpu).setVisible(true);
        });
    }
}
