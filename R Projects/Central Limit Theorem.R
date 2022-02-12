#Central Limit Theorem
CLT_plot=function(n1,size,p) {
  Bdata1=c()
  Bdata2=c()
  Bdata3=c()
  Bdata4=c()
  for (i in c(1:5)) Bdata1<-c(Bdata1,mean(rbinom(n1,size,p)))
  for (i in c(1:10)) Bdata2<-c(Bdata2,mean(rbinom(n1,size,p)))
  for (i in c(1:100)) Bdata3<-c(Bdata3,mean(rbinom(n1,size,p)))
  for (i in c(1:1000)) Bdata4<-c(Bdata4,mean(rbinom(n1,size,p)))
  
  par(mfrow=c(2, 2),mar=c(4,4,2,2),oma=c(2,2,5,2)) #add figures by row
  
  hist(Bdata1,main="n=5",xlab="")
  hist(Bdata2,main="n=10",xlab="")
  hist(Bdata3,main="n=100",xlab="")
  hist(Bdata4,main="n=1000",xlab="")
  title("Simulation of CLT with binominal",outer=TRUE)
}