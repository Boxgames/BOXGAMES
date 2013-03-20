package br.com.bgames.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EncaminharDados {
    void executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception;
}