package com.sunbeaminfo.dac.spmvc03.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeaminfo.dac.spmvc03.entities.Addmin;
import com.sunbeaminfo.dac.spmvc03.entities.Bank;
import com.sunbeaminfo.dac.spmvc03.entities.BillDetails;
import com.sunbeaminfo.dac.spmvc03.entities.Call_Details;
import com.sunbeaminfo.dac.spmvc03.entities.CashmodeSelect;
import com.sunbeaminfo.dac.spmvc03.entities.Connection;
import com.sunbeaminfo.dac.spmvc03.entities.Customer;
import com.sunbeaminfo.dac.spmvc03.entities.PaymentDetails;
import com.sunbeaminfo.dac.spmvc03.entities.SmsDetails;
import com.sunbeaminfo.dac.spmvc03.entities.TarrifPlan;
import com.sunbeaminfo.dac.spmvc03.entities.User;

@Repository
public class CustomerDaoImpl {
	@Autowired
	private SessionFactory factory;

	// to register the customer
	public void add(Customer c) {
		Session session = factory.getCurrentSession();
		session.persist(c);
	}

	// list of all customers
	public List<Customer> getAllCustomers() {
		String hql = "from Customer";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		List<Customer> list = q.list();
		// System.out.println(list);
		return list;

	}

	// login time addmin details
	public Addmin getAdmin(int id, int password) {
		String hql = "from Addmin a where a.id=:p_Id and a.password=:p_pas ";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("p_Id", id);
		q.setParameter("p_pas", password);
		Addmin ad = (Addmin) q.getSingleResult();
		return ad;

	}

	public List<TarrifPlan> selectPlan() {
		String hql = "from TarrifPlan";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);

		List<TarrifPlan> plans = q.getResultList();
		return plans;
	}

	// to delete customer
	public int deleteCustomer(int c_Id) {
		String hql = "delete from Customer c where Customer_Id=:p_id";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("p_id", c_Id);
		int rowAffect = q.executeUpdate();
		return rowAffect;
	}

	// to update the customer profile
	public int udateCustomer(int c_Id, String name, String email, String address, String password) {
		String hql = "UPDATE Customer  SET " + "Name=:p_name," + "Email=:p_email," + "Address=:p_address,"
				+ "Password=:p_password" + " " + "WHERE Customer_Id=:p_id";
		System.out.println(hql);
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("p_id", c_Id);
		q.setParameter("p_name", name);
		q.setParameter("p_email", email);
		q.setParameter("p_address", address);
		q.setParameter("p_password", password);

		int rowAffect = q.executeUpdate();
		return rowAffect;
	}

	// list of all calls
	public List<Call_Details> getAllCallList() {
		String hql = "from Call_Details";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		List<Call_Details> list = q.list();
		// System.out.println(list);
		return list;

	}

	/*
	 * //login time customer details public User getCustomer(String email,String
	 * password) { String hql =
	 * "from Customer  c where c.Email=:email and c.Password=:password"; Session
	 * session = factory.getCurrentSession(); Query q =
	 * session.createQuery(hql); System.out.println(hql);
	 * System.out.println("i am here"); q.setParameter("email", email);
	 * q.setParameter("password",password); return (User)q.getSingleResult();
	 * 
	 * }
	 */

	// to get customer on connection id
	public Customer getCustomer(int Connection_Id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, Connection_Id);
	}

	// to get connection details on customer id
	public Connection getConnection(int Customer_Id) {
		Session session = factory.getCurrentSession();
		return session.get(Connection.class, Customer_Id);
	}

	// to get connection list on customer_id
	public List<Connection> getConList(int id) {
		String hql = "from Connection c where c.Customer_Id=:p_id";
		Session session = factory.getCurrentSession();
		System.out.println(hql);
		Query q = session.createQuery(hql);
		q.setParameter("p_id", id);
		List<Connection> conList = q.list();
		return conList;
	}

	// to get call details of perticular connection number
	public List<Call_Details> getCallDetailsOfPerticularConnection(int conId) {
		String hql = "from Call_Details c where Connection_Id=:p_conId";
		Session session = factory.getCurrentSession();
		System.out.println(hql);
		Query q = session.createQuery(hql);
		q.setParameter("p_conId", conId);
		List<Call_Details> callList = q.list();
		return callList;
	}

	public List<BillDetails> getBillList() {
		String hql = "from BillDetails";
		Session session = factory.getCurrentSession();
		System.out.println(hql);
		Query q = session.createQuery(hql);
		List<BillDetails> billList = q.list();
		System.out.println(billList);
		return billList;
	}

	public List<BillDetails> getBillListByConnectionId(int conId) {
		String hql = "from BillDetails b where Connection_Id=:p_Id";
		Session session = factory.getCurrentSession();
		System.out.println(hql);
		Query q = session.createQuery(hql);
		q.setParameter("p_Id", conId);
		List<BillDetails> billList = q.list();
		System.out.println(billList);
		return billList;
	}

	public List<BillDetails> getBillListByCustomerId(int custId) {
		String hql = "from BillDetails b where Customer_Id=:p_Id";
		Session session = factory.getCurrentSession();
		System.out.println(hql);
		Query q = session.createQuery(hql);
		q.setParameter("p_Id", custId);
		List<BillDetails> billList = q.list();
		System.out.println(billList);
		return billList;
	}

	public Customer getCustomerProfile(int custId) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, custId);
	}

	public List<TarrifPlan> getTarrifPlan() {
		String hql = "from TarrifPlan";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		List<TarrifPlan> list = q.list();
		System.out.println(list);
		return list;
	}

	public List<SmsDetails> getSmsList() {
		String hql = "from SmsDetails";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		List<SmsDetails> smsList = q.list();
		System.out.println(smsList);
		return smsList;
	}

	public List<SmsDetails> getSmsListByConId(int conId) {
		String hql = "from SmsDetails s where Connection_Id=:conId";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("conId", conId);
		List<SmsDetails> smsList = q.list();
		System.out.println(smsList);
		return smsList;
	}

	public List<PaymentDetails> getPaymentDetails(int billId) {
		String hql = "from PaymentDetails p where Bill_Id=:billId";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("billId", billId);
		List<PaymentDetails> paymentList = q.list();
		System.out.println(paymentList);
		return paymentList;

	}

	public int doPayment(int conId) {
		String hql = "insert into PaymentDetails(Ammount) "
				+ "select sum(Charges) from BillDetails where Connection_Id=:conId";
		System.out.println(hql);
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("conId", conId);
		int row = query.executeUpdate();
		return row;
	}

	public int getBillPayment(int conId) {
		double val1 = this.getCallCharges(conId);
		double val2 = this.getSmsCharges(conId);

		double val3 = val1 + val2;
		BillDetails b = null;
		// b.setCharges(val3);

		String hql = "update BillDetails set Charges=" + val3 + " " + "where Connection_Id=:conId";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("conId", conId);

		int r = q.executeUpdate();
		return r;
	}

	public double getCallCharges(int conId) {
		String hql = "select sum(Charges) from Call_Details where Connection_Id=:conId";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("conId", conId);
		double res = (double) q.getSingleResult();
		return res;
	}

	public double getSmsCharges(int conId) {
		String hql = "select sum(Charges) from SmsDetails where Connection_Id=:conId";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("conId", conId);
		double res = (double) q.getSingleResult();
		return res;
	}

	public double getTotalBill(int conId) {
		String hql = "select Charges from BillDetails where Connection_Id=:conId";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("conId", conId);
		double res = (double) q.getSingleResult();
		return res;
	}
	public boolean payment(CashmodeSelect c) {
		String hql = "from Bank b where b.Customer_id =:id ";
		Session session = factory.getCurrentSession();
		Query q = session.createQuery(hql);
		q.setParameter("id", c.getCust_id());
		Bank b = (Bank) q.getSingleResult();
		if(b != null && b.getBalance() > c.getAmount() )
		{
			b.setBalance(b.getBalance() - c.getAmount());
			session.update(b); 
			
			/** Transfer money to admin*/
			Query qry = session.createQuery(hql);
			q.setParameter("id", 2 );
			Bank b1 = (Bank) q.getSingleResult();
			b1.setBalance(b1.getBalance() + c.getAmount());
			session.update(b1);
			return true;
		}
		return false; 
	}
}
