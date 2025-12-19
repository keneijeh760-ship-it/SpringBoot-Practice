package com.phope.hope.Controller;

import com.phope.hope.Entity.TransferRequest;
import com.phope.hope.Service.BankingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfers")
public class BankingController {


    private final BankingService bankingService;



    public BankingController( BankingService bankingService){

        this.bankingService = bankingService;

    }



    @PostMapping
    public void MoneyTransfer (@RequestBody TransferRequest request){
        bankingService.TransferMoney(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );
    }


}
