package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String invoiceNumber;
    private String clientName;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private ArrayList<InvoiceItem> invoiceItems;
    private boolean paymentStatus;

    public Invoice(String invoiceNumber, String clientName, LocalDate dueDate) {
        this.invoiceNumber = invoiceNumber;
        this.clientName = clientName;
        this.dueDate = dueDate;
        this.issueDate = LocalDate.now();
        this.invoiceItems = new ArrayList<>();
        this.paymentStatus = false;
    }

    public void addItem(InvoiceItem item) {
        this.invoiceItems.add(item);
    }

    public double getTotal() {
        int size = invoiceItems.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += invoiceItems.get(i).getAmount();
        }

        return sum;
    }

    public void markAsPaid() {
        this.paymentStatus = true;
    }

    public String getInvoiceNum() {
        return this.invoiceNumber;
    }

    public String getClientName() {
        return this.clientName;
    }

    public LocalDate getDueDate() {

        return this.dueDate;

    }

    public boolean isPaid() {
        return this.paymentStatus;
    }
}
