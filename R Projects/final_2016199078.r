#1
diff_f=function(N) {
  sq_of_sum <- (sum(1:N))^2 #square of sum
  sum_of_sq <-sum(sapply(c(1:N), function(x) x^2)) #sum of squares
  return(sq_of_sum-sum_of_sq)
}


#2
ss_sum=function(N) { #N>0, natural number
  temp=N
  i=0
  while(temp>0) {
    temp=temp%/%10
    i=i+1
  }
  num_of_digits=i
  
  digits=c()
  j=1
  while(j<=num_of_digits) {
    digits <- c(digits,N%%10)
    N=N%/%10
    j=j+1
  }
  
  return(sum(digits))
}


#3
df_summary=function(data) {
  return_value=0
  numeric_bool=FALSE
  stop=FALSE
  
  #check whether numeric value exists in data
  for(i in c(1:nrow(data))) {
    for(j in c(1:ncol(data))) {
      if(mode(data[i,j])=="numeric") numeric_bool=TRUE #TRUE if at least one variable is numeric
        stop=TRUE
    }
    if(stop==TRUE) break #break loop if at least one variable is numeric
  }
  
  #change string values to NA
  for (i in c(1:nrow(data))) {
    for (j in c(1:ncol(data))) if(is.character(data[i,j])) data[i,j]<-NA
  }
  
  #find columns that do not have all NAs
  selected=c()
  for(i in c(1:ncol(data))) {
    if(!all(is.na(data[i]))) selected=c(selected,i) 
  }
  
  #create matrix for returning summary data
  summary=matrix(nrow=length(selected),ncol=5)
  rownames(summary)<-colnames(data)[selected]
  colnames(summary)<-c("min","mean","median","max","sd")
  
  #store values in 'summary' matrix
  val=1
  for(i in selected) {
    min<-min(data[i][!is.na(data[i])])
    mean<-mean(data[i][!is.na(data[i])])
    median<-median((data[i][!is.na(data[i])]))
    max<-max((data[i][!is.na(data[i])]))
    sd<-round(sd((data[i][!is.na(data[i])])),digits=3)
    summary[val,]<-c(min,mean,median,max,sd)
    val=val+1
  }
  
  if(numeric_bool==TRUE) {
    return_value=summary 
  } else { #numeric_bool==FALSE
    return_value="None Numeric Variable"}
  
  return(return_value)
}


#4
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
