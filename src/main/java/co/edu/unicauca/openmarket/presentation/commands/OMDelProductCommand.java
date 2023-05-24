/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.presentation.commands;


import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SANTIAGO
 */
public class OMDelProductCommand extends OMCommand{
    
    private ProductService pS;
    private Product producto;
    boolean result=false;
    long idProduct;
    
    public OMDelProductCommand(long id, ProductService pS){
        this.idProduct = id;
        this.pS = pS;
    }

    @Override
    public void make() {
        try {
            producto = pS.findProductById(idProduct);
            result = pS.deleteProduct(idProduct);
        } catch (Exception ex) {
            Logger.getLogger(OMDelProductCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unmake() {
          try {
            pS.saveProduct( producto.getProductId(), producto.getName(), producto.getDescription());
            result = true;
        } catch (Exception ex) {
            Logger.getLogger(OMDelProductCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public boolean result(){
        return result;
    }

    @Override
    public void remake() {
        make();
    }
    
    
}
