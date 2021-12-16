### CVA Calculator
This tool calculates the credit valuation adjustment for a risky bond.

Steps to calculating CVA adjustment:
1. Get exposure for each year 
1. Get assumed recovery if default occur (exposure from step 1 multiplied by recovery rate)
1. Loss given default = exposure - recovery
1. Probability of default (hazard rate * previous year's probability of survival)
1. Probability of survival (1 - probability of default raised to the power of the number of the years)
1. Expected loss (loss given default * probability of default)
1. Discount factors based on the flat government bond yield curve
1. Present value of the expected loss for each year
1. CVA is the sum of the present values of expected losses

### Assumptions
* No interest rate volatility
* Default can only occur at year end
* Hazard rate does not change over the lifetime of the bond

### Next steps
* Calculate adjusted exposure
* Use CVA to calculate the credit spread of the corporate bond
* Relax some assumptions 