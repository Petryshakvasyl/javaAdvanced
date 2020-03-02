package ua.lviv.lgs.magazine.controllers;

import org.apache.log4j.Logger;
import ua.lviv.lgs.magazine.domain.Product;
import ua.lviv.lgs.magazine.service.ProductService;
import ua.lviv.lgs.magazine.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class ProductsController extends HttpServlet {

    private Logger log = Logger.getLogger(ProductsController.class);
    private ProductService productService;

    public ProductsController() {
        productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Object> emailObj = Optional.ofNullable(req.getSession().getAttribute("userName"));
        if (emailObj.isPresent()) {
            String email = String.valueOf(emailObj.get());
            req.setAttribute("userEmail", email);
        }

        log.debug("get request for products");
        List<Product> products = productService.findAll();

        log.debug("products: " + products);
        req.setAttribute("products", products);

        log.debug("forward");
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }
}
