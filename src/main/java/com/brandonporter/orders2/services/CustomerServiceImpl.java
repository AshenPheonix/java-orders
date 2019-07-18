package com.brandonporter.orders2.services;

import com.brandonporter.orders2.models.Customer;
import com.brandonporter.orders2.models.Order;
import com.brandonporter.orders2.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository custrepo;

    @Override
    public List<Customer> getAllByOrders() {
        List<Customer> list = new ArrayList<>();

        custrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer getByName(String name) {
        Customer cust = custrepo.findByName(name);
        if(cust==null){
            throw new EntityNotFoundException("Customer "+name+" Not Found");
        }
        return cust;
    }

    @Transactional
    @Override
    public void deleteCustomer(long id) {
        if(custrepo.findById(id).isPresent()){
            custrepo.deleteById(id);
        }else{
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer temp = new Customer();

        temp.setCustcity(customer.getCustcity());
        temp.setWorkingarea(customer.getWorkingarea());
        temp.setCustcountry(customer.getCustcountry());
        temp.setGrade(customer.getGrade());
        temp.setPhone(customer.getPhone());
        temp.setOpeningamt(customer.getOpeningamt());
        temp.setRecieveamt(customer.getRecieveamt());
        temp.setPaymentamt(customer.getPaymentamt());
        temp.setOutstandingamt(customer.getOutstandingamt());
        temp.setAgent(customer.getAgent());

        for (Order o: customer.getOrders()) {
            temp.getOrders().add(new Order(o.getOrdamount(),o.getAdvanceamount(),temp,o.getOrddescripion()));
        }

        return custrepo.save(temp);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long id) {
        Customer cust =custrepo.findById(id).orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));
        if (customer.getName()!=null)
            cust.setName(customer.getName());
        if(customer.getWorkingarea()!=null)
            cust.setWorkingarea(customer.getWorkingarea());
        if(customer.getCustcountry()!=null)
            cust.setCustcountry(customer.getCustcountry());
        if(customer.getGrade()!=null)
            cust.setGrade(customer.getGrade());
        if(customer.getPhone()!=null)
            cust.setPhone(cust.getPhone());
        cust.setOpeningamt(customer.getOpeningamt());
        cust.setRecieveamt(customer.getRecieveamt());
        cust.setPaymentamt(customer.getPaymentamt());
        cust.setOutstandingamt(customer.getOutstandingamt());
        if(customer.getAgent()!=null)
            cust.setAgent(customer.getAgent());

        if(customer.getOrders().size()>0){
            for(Order o : customer.getOrders()){
                cust.getOrders().add(new Order(o.getOrdamount(),o.getAdvanceamount(),cust,o.getOrddescripion()));
            }
        }

        return custrepo.save(cust);
    }
}
