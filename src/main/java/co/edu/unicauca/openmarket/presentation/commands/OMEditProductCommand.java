
package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;

/**
 *
 * @author SANTIAGO
 */

public class OMEditProductCommand  extends OMCommand{
    private Product pP;
    private ProductService pS;
    boolean result=false;
    private Product prodAux;

    public OMEditProductCommand(Product pP, ProductService pS) {
        this.pP = pP;
        this.pS = pS;
    }

    @Override
    public void make() {
        prodAux = pS.findProductById(pP.getProductId());
        result = pS.editProduct(pP.getProductId(), pP);
    }

    @Override
    public void unmake() {
        pS.editProduct(prodAux.getProductId(), prodAux);
    }

    @Override
    public void remake() {
        make();
    }
    
     public boolean result(){
        return result;
    }
    
    
}
