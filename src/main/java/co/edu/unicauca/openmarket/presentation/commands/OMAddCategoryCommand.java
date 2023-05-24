/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import java.util.List;

/**
 *
 * @author SANTIAGO
 */
public class OMAddCategoryCommand extends  OMCommand{

    private ProductService pS;
    Category category;
    List<Product> lstProducts;
    boolean result=false;
    
    public OMAddCategoryCommand(Category category,  List<Product> lstProducts, ProductService productService) {
        pS = productService;
        this.category = category;
        this.lstProducts = lstProducts;
    }
    
    
    @Override
    public void make() {
        for(int i=0; i<lstProducts.size(); i++){
            Product prod = lstProducts.get(i);
            prod.setCategory(category);
             pS.editProduct(prod.getProductId(), prod);
        }
        result = true;
    }

    @Override
    public void unmake() {
        for(int i=0; i<lstProducts.size(); i++){
            Product prod = lstProducts.get(i);
            prod.setCategory(null);
            pS.editProduct(prod.getProductId(), prod);
        }
    }

    @Override
    public void remake() {
        make();
    }
    
    public boolean result(){
        return result;
    }
    
}
